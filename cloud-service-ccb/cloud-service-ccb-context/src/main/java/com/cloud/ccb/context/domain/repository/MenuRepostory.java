package com.cloud.ccb.context.domain.repository;

import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.core.EntityObjectUtils;
import cn.liberfree.de.loader.EntityLoader;
import cn.liberfree.de.repository.IRepository;
import com.cloud.ccb.context.domain.mappers.ButtonDmoMapper;
import com.cloud.ccb.context.domain.mappers.MenuDmoMapper;
import com.cloud.ccb.context.domain.mappers.dmo.ButtonDmo;
import com.cloud.ccb.context.domain.mappers.dmo.ButtonDmoExample;
import com.cloud.ccb.context.domain.mappers.dmo.MenuDmo;
import com.cloud.ccb.context.domain.model.Button;
import com.cloud.ccb.context.domain.model.Menu;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: zhangchao
 * @time: 2018-11-20 15:46
 **/
@Component
public class MenuRepostory implements IRepository<Menu,String> {

    @Autowired
    private MenuDmoMapper menuDmoMapper;

    @Autowired
    private ButtonDmoMapper buttonDmoMapper;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Menu load(String id, EntityLoader entityLoader) {
        if(id == null){
            throw new BusinessException("id is null");
        }
        MenuDmo menuDmo = menuDmoMapper.selectByPrimaryKey(String.valueOf(id));
        if(menuDmo == null){
            return null;
        }
        Menu menu = entityLoader.create(Menu.class);
        mapper.map(menuDmo,menu);


        ButtonDmoExample example = new ButtonDmoExample();
        example.createCriteria().andMenuIdEqualTo(menu.getId());
        List<ButtonDmo> buttonDmos = buttonDmoMapper.selectByExample(example);
        if(buttonDmos != null){
            Set<Button> buttonSet = buttonDmos.stream().map(item -> mapper.map(item, Button.class)).collect(Collectors.toSet());
            EntityObjectUtils.setValue(Menu.class,menu,"buttonSet",buttonSet);
        }

        return menu;
    }

    @Override
    public void save(Menu menu) {
        if(menu == null){
            throw new BusinessException("menu is null");
        }

        MenuDmo map = mapper.map(menu, MenuDmo.class);
        if(menuDmoMapper.updateByPrimaryKey(map) == 0){
            menuDmoMapper.insert(map);
        }
        Set<Button> buttonSet = menu.getButtonSet();
        ButtonDmoExample example = new ButtonDmoExample();
        example.createCriteria().andMenuIdEqualTo(menu.getId());
        buttonDmoMapper.deleteByExample(example);



        if(buttonSet != null){
            buttonSet.stream() .forEach(item->{
                ButtonDmo buttonDmo = mapper.map(item, ButtonDmo.class);
                buttonDmo.setMenuId(map.getId());
                buttonDmoMapper.insert(buttonDmo);
            });
        }

    }

    @Override
    public void delete(Menu menu) {
        if(menu == null){
            throw new BusinessException("id is null");
        }
        menuDmoMapper.deleteByPrimaryKey(menu.getId());
        ButtonDmoExample example = new ButtonDmoExample();
        example.createCriteria().andMenuIdEqualTo(menu.getId());
        buttonDmoMapper.deleteByExample(example);
    }
}
