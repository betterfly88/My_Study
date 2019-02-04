package designpattern.prototype.mongo;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class DBMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        DBInfo db1 = new DBInfo();
        db1.setDbId(1);
        db1.setDbInfo("첫번째 디비");

        DBInfo db2 = (DBInfo)db1.clone();
        db2.setDbId(2);
        db2.setDbInfo("두번째 디비");

        System.out.println(db1);
        System.out.println(db2);
    }
}
