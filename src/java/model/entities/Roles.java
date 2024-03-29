package model.entities;
// Generated 17/08/2013 10:51:39 PM by Hibernate Tools 3.2.1.GA

/**
 * Roles generated by hbm2java
 */
public class Roles implements java.io.Serializable {

    private int roleId;
    private String roleType;

    /*
     * Default constractor
     */
    public Roles() {
    }
    
    /*
     * Constractor with param
     */
    public Roles(int roleId, String roleType) {
        this.roleId = roleId;
        this.roleType = roleType;
    }

    /*
     * Getter and Setter
     */
    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return this.roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
