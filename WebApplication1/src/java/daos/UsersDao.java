/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import persistance.models.Users;

/**
 *
 * @author mitta
 */
public interface UsersDao extends java.io.Serializable {
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    Users get(String username, String password);
    
    /**
     *
     * @param user
     * @return 
     */
    Integer create(Users user);
}
