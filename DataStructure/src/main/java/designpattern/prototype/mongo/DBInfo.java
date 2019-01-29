package designpattern.mongo;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class DBInfo implements Cloneable{
    private String dbInfo;
    private Integer dbId;

    @Override
    public String toString() {
        return "DBInfo{" +
                "dbInfo='" + dbInfo + '\'' +
                ", dbId=" + dbId +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getDbInfo() {
        return dbInfo;
    }

    public void setDbInfo(String dbInfo) {
        this.dbInfo = dbInfo;
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }
}
