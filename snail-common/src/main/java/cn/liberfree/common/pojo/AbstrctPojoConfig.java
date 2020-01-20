package cn.liberfree.common.pojo;

/**
 * @author: zhangchao
 * @time: 2018-09-05 09:48
 **/
@Deprecated
public abstract class AbstrctPojoConfig {
    PojoConfig config = new PojoConfig();
    {
        try {
            config(config);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public abstract void config(PojoConfig pojoConfig) throws NoSuchFieldException;
}
