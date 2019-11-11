package dao;

import bean.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends BaseDao {
    public int Validate(String account, String password) {
        String sql = "select * from users where Account = '" + account + "' and Password = '" + password + "'";
        System.out.println(sql);
        ResultSet resultSet = query(sql);
        try {
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}
