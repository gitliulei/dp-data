package net.astroway.yw.rrsdp.util;

import net.astroway.yw.base.sys.model.Organization;
import net.astroway.yw.base.sys.model.Privilege;
import net.astroway.yw.base.sys.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by syk on 2017/10/12.
 */
public class SessionSysUser{
        private String id;
        private String userName;
        private String name;
        private String phone;
        private String email;
        private String idCard;
        private Date birthday;
        private Integer sex;
        private String nickName;
        private String iconUrl;
        private Integer orgId;
        private Organization organization;
        private List<Privilege> privileges;

        public SessionSysUser() {
        }

        public String  getId() {
            return this.id;
        }

        public String getUserName() {
            return this.userName;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public String getEmail() {
            return this.email;
        }

        public String getIdCard() {
            return this.idCard;
        }

        public Date getBirthday() {
            return this.birthday;
        }

        public Integer getSex() {
            return this.sex;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public Integer getOrgId() {
            return this.orgId;
        }

        public Organization getOrganization() {
            return this.organization;
        }

        public List<Privilege> getPrivileges() {
            return this.privileges;
        }

        public void setId(String  id) {
            this.id = id;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public void setOrgId(Integer orgId) {
            this.orgId = orgId;
        }

        public void setOrganization(Organization organization) {
            this.organization = organization;
        }

        public void setPrivileges(List<Privilege> privileges) {
            this.privileges = privileges;
        }

        public boolean equals(Object o) {
            if(o == this) {
                return true;
            } else if(!(o instanceof User)) {
                return false;
            } else {
                SessionSysUser other = (SessionSysUser) o;
                if(!other.canEqual(this)) {
                    return false;
                } else {
                    label167: {
                        Object this$id = this.getId();
                        Object other$id = other.getId();
                        if(this$id == null) {
                            if(other$id == null) {
                                break label167;
                            }
                        } else if(this$id.equals(other$id)) {
                            break label167;
                        }

                        return false;
                    }

                    Object this$userName = this.getUserName();
                    Object other$userName = other.getUserName();
                    if(this$userName == null) {
                        if(other$userName != null) {
                            return false;
                        }
                    } else if(!this$userName.equals(other$userName)) {
                        return false;
                    }

                    label153: {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if(this$name == null) {
                            if(other$name == null) {
                                break label153;
                            }
                        } else if(this$name.equals(other$name)) {
                            break label153;
                        }

                        return false;
                    }

                    Object this$phone = this.getPhone();
                    Object other$phone = other.getPhone();
                    if(this$phone == null) {
                        if(other$phone != null) {
                            return false;
                        }
                    } else if(!this$phone.equals(other$phone)) {
                        return false;
                    }

                    label139: {
                        Object this$email = this.getEmail();
                        Object other$email = other.getEmail();
                        if(this$email == null) {
                            if(other$email == null) {
                                break label139;
                            }
                        } else if(this$email.equals(other$email)) {
                            break label139;
                        }

                        return false;
                    }

                    Object this$idCard = this.getIdCard();
                    Object other$idCard = other.getIdCard();
                    if(this$idCard == null) {
                        if(other$idCard != null) {
                            return false;
                        }
                    } else if(!this$idCard.equals(other$idCard)) {
                        return false;
                    }

                    label125: {
                        Object this$birthday = this.getBirthday();
                        Object other$birthday = other.getBirthday();
                        if(this$birthday == null) {
                            if(other$birthday == null) {
                                break label125;
                            }
                        } else if(this$birthday.equals(other$birthday)) {
                            break label125;
                        }

                        return false;
                    }

                    label118: {
                        Object this$sex = this.getSex();
                        Object other$sex = other.getSex();
                        if(this$sex == null) {
                            if(other$sex == null) {
                                break label118;
                            }
                        } else if(this$sex.equals(other$sex)) {
                            break label118;
                        }

                        return false;
                    }

                    Object this$nickName = this.getNickName();
                    Object other$nickName = other.getNickName();
                    if(this$nickName == null) {
                        if(other$nickName != null) {
                            return false;
                        }
                    } else if(!this$nickName.equals(other$nickName)) {
                        return false;
                    }

                    label104: {
                        Object this$iconUrl = this.getIconUrl();
                        Object other$iconUrl = other.getIconUrl();
                        if(this$iconUrl == null) {
                            if(other$iconUrl == null) {
                                break label104;
                            }
                        } else if(this$iconUrl.equals(other$iconUrl)) {
                            break label104;
                        }

                        return false;
                    }

                    label97: {
                        Object this$orgId = this.getOrgId();
                        Object other$orgId = other.getOrgId();
                        if(this$orgId == null) {
                            if(other$orgId == null) {
                                break label97;
                            }
                        } else if(this$orgId.equals(other$orgId)) {
                            break label97;
                        }

                        return false;
                    }

                    Object this$organization = this.getOrganization();
                    Object other$organization = other.getOrganization();
                    if(this$organization == null) {
                        if(other$organization != null) {
                            return false;
                        }
                    } else if(!this$organization.equals(other$organization)) {
                        return false;
                    }

                    Object this$privileges = this.getPrivileges();
                    Object other$privileges = other.getPrivileges();
                    if(this$privileges == null) {
                        if(other$privileges != null) {
                            return false;
                        }
                    } else if(!this$privileges.equals(other$privileges)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof SessionSysUser;
        }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $id = this.getId();
//        int result = result * 59 + ($id == null?43:$id.hashCode());
//        Object $userName = this.getUserName();
//        result = result * 59 + ($userName == null?43:$userName.hashCode());
//        Object $name = this.getName();
//        result = result * 59 + ($name == null?43:$name.hashCode());
//        Object $phone = this.getPhone();
//        result = result * 59 + ($phone == null?43:$phone.hashCode());
//        Object $email = this.getEmail();
//        result = result * 59 + ($email == null?43:$email.hashCode());
//        Object $idCard = this.getIdCard();
//        result = result * 59 + ($idCard == null?43:$idCard.hashCode());
//        Object $birthday = this.getBirthday();
//        result = result * 59 + ($birthday == null?43:$birthday.hashCode());
//        Object $sex = this.getSex();
//        result = result * 59 + ($sex == null?43:$sex.hashCode());
//        Object $nickName = this.getNickName();
//        result = result * 59 + ($nickName == null?43:$nickName.hashCode());
//        Object $iconUrl = this.getIconUrl();
//        result = result * 59 + ($iconUrl == null?43:$iconUrl.hashCode());
//        Object $orgId = this.getOrgId();
//        result = result * 59 + ($orgId == null?43:$orgId.hashCode());
//        Object $organization = this.getOrganization();
//        result = result * 59 + ($organization == null?43:$organization.hashCode());
//        Object $privileges = this.getPrivileges();
//        result = result * 59 + ($privileges == null?43:$privileges.hashCode());
//        return result;
//    }

        public String toString() {
            return "SessionSysUser(id=" + this.getId() + ", userName=" + this.getUserName() + ", name=" + this.getName() + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", idCard=" + this.getIdCard() + ", birthday=" + this.getBirthday() + ", sex=" + this.getSex() + ", nickName=" + this.getNickName() + ", iconUrl=" + this.getIconUrl() + ", orgId=" + this.getOrgId() + ", organization=" + this.getOrganization() + ", privileges=" + this.getPrivileges() + ")";
        }
}
