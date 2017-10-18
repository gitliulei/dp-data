//package net.astroway.yw.rrsdp.util;
//
///*******************************************************************************
// * Copyright (C) 1999, 2000, 2001 Novell, Inc. All Rights Reserved.
// *
// * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND
// * TREATIES. USE AND REDISTRIBUTION OF THIS WORK IS SUBJECT TO THE LICENSE
// * AGREEMENT ACCOMPANYING THE SOFTWARE DEVELOPMENT KIT (SDK) THAT CONTAINS
// * THIS WORK. PURSUANT TO THE SDK LICENSE AGREEMENT, NOVELL HEREBY GRANTS TO
// * DEVELOPER A ROYALTY-FREE, NON-EXCLUSIVE LICENSE TO INCLUDE NOVELL'S SAMPLE
// * CODE IN ITS PRODUCT. NOVELL GRANTS DEVELOPER WORLDWIDE DISTRIBUTION RIGHTS
// * TO MARKET, DISTRIBUTE, OR SELL NOVELL'S SAMPLE CODE AS A COMPONENT OF
// * DEVELOPER'S PRODUCTS. NOVELL SHALL HAVE NO OBLIGATIONS TO DEVELOPER OR
// * DEVELOPER'S CUSTOMERS WITH RESPECT TO THIS CODE.
// *
// * $name:           VerifyPassword.java
// * $description:    The VerifyPassword.java sample verifies that a password is
// *                  correct for the given entry.
// *
// *                  We simply compare the password with the "userPassword"
// *                  attribute of the entry using the LDAP compare function.
// *
// ******************************************************************************/
//import com.novell.ldap.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.UnsupportedEncodingException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///*import com.novell.ldap.LDAPAttribute;
//import com.novell.ldap.LDAPAttributeSet;
//import com.novell.ldap.LDAPConnection;
//import com.novell.ldap.LDAPEntry;
//import com.novell.ldap.LDAPException;
//import com.novell.ldap.LDAPSearchResults;*/
//@Controller
//@RequestMapping("/login")
//public class LdapUserAuth{
//
//	/**
//	 * 获得ldap链接
//	 * @return
//	 */
//    private static synchronized LDAPConnection getLDAPConnection(String ldapHost, String loginDN, String password){
//    	LDAPConnection lc = null;
//    	try {
//	    	int ldapVersion = LDAPConnection.LDAP_V3;
//	        int ldapPort = 389;
//	        lc = new LDAPConnection();
//			lc.connect( ldapHost, ldapPort );
//			lc.bind( ldapVersion, loginDN, password );
//			return lc;
//		} catch (LDAPException e) {
//			e.printStackTrace();
//			if(lc != null){
//				try {
//					lc.disconnect();
//					lc = null;
//				} catch (LDAPException e1) {
//					e1.printStackTrace();
//				}
//			}
//			return null;
//		}
//    }
//	/**
//	 * 释放ldap链接
//	 * @param lc
//	 */
//    private static void releaseLDAPConnection(LDAPConnection lc){
//    	try {
//    		if(lc != null){
//    			lc.disconnect();
//    			lc = null;
//    		}
//		} catch (LDAPException e) {
//			e.printStackTrace();
//		}
//    }
//	/**
//	 * 获得dn
//	 * @param lc
//	 * @param cn : 工号cn
//	 * @return
//	 */
//    private static synchronized String getDN(LDAPConnection lc,String cn){
//    	 try {
//    		 if((cn == null || "".equals(cn))){
//	   			 return null;
//	   		 }
//			 //haier 下面只查cn
//             String searchBase = "o=haier";
//             String searchFilter = "(&(cn="+cn+")(objectClass=user))";
//             int searchScope = LDAPConnection.SCOPE_SUB;
//             LDAPSearchResults searchResults = lc.search(searchBase,searchScope, searchFilter.toString(), null, false);
//             while (searchResults.hasMore()) {
//                 LDAPEntry nextEntry = null;
//                 nextEntry = searchResults.next();
//                 String str = nextEntry.getDN();
//                 return str;
//             }
//             return null;
//         } catch (LDAPException t) {
//         	t.printStackTrace();
//         	return null;
//         }
//    }
//	/**
//	 * 校验用户是否合法
//	 */
//    public  void checkInfo(String ldapHost,String loginDN,String loginPassword,String dn,String pwd){
//    	int ldapVersion   = LDAPConnection.LDAP_V3;
//        int ldapPort      = 389;
//        LDAPConnection lc = new LDAPConnection();
//        try {
//            lc.connect( ldapHost, ldapPort );
//            lc.bind( ldapVersion, loginDN, loginPassword.getBytes("UTF8") );
//            Map<String,String> map  = getOperationalAttrs( lc, dn );
//			//开始判断
//			String logindisabled = map.get("logindisabled");
//			if(logindisabled.equalsIgnoreCase("TRUE")){
//				System.out.println("用户已被锁定！");
//				return;
//			}
//			String loginIntruderAttempts = map.get("loginIntruderAttempts");
//			if(loginIntruderAttempts!=null && !"".equals(loginIntruderAttempts)){
//				int loginIntruderAttemptsInt = Integer.parseInt(loginIntruderAttempts);
//				if(loginIntruderAttemptsInt>=5){
//					System.out.println("账号锁定，输入错误密码次数"+loginIntruderAttemptsInt+"次！");
//					return;
//				}
//			}
//			//超期
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssZ");
//			String now = sdf.format(new Date());
//			String loginExpirationTime = map.get("loginExpirationTime");
//			if(loginExpirationTime!=null && !"".equals(loginExpirationTime)){
//				if(now.compareTo(loginExpirationTime)>0){
//					System.out.println("用户密码已经过期！");
//					return;
//				}
//			}
//			//强制修改密码
//			String passwordExpirationTime = map.get("passwordExpirationTime");
//			if(passwordExpirationTime!=null && !"".equals(passwordExpirationTime)){
//				if(now.compareTo(passwordExpirationTime)>0){
//					System.out.println("2个月内未修改密码，请修改后再登录");
//					return;
//				}
//			}
//			//判断密码
//			LDAPAttribute pwdAttr = new LDAPAttribute("userPassword", pwd );
//			boolean pwdCorrect = lc.compare( dn, pwdAttr );
//			System.out.println( pwdCorrect ? "密码正确":"密码错误.\n");
//            lc.disconnect();
//        }catch( LDAPException e ) {
//            System.out.println( "\nError: " + e.toString() );
//            System.exit(1);
//        }catch( UnsupportedEncodingException e ) {
//            System.out.println( "Error: " + e.toString() );
//        }
//        System.exit(0);
//    }
//	/**
//	 * 获取用户属性信息
//	 * @param lc
//	 * @param dn
//	 * @throws LDAPException
//	 */
//    public Map<String,String>  getOperationalAttrs( LDAPConnection lc, String dn)throws LDAPException{
//    	String returnAttrs[] = {"logindisabled","loginExpirationTime","loginIntruderAttempts","passwordExpirationTime"};
//    	Map<String,String> map = new HashMap<String,String>();
//        String attributeName, attrValue;
//        Iterator allAttributes;
//        Enumeration allValues;
//        LDAPAttribute attribute;
//        LDAPAttributeSet attributeSet;
//        for(String str:returnAttrs){
//        	map.put(str, "");
//        }
//        try {
//            LDAPEntry entry = lc.read( dn, returnAttrs );
//            attributeSet = entry.getAttributeSet();
//            allAttributes = attributeSet.iterator();
//            while(allAttributes.hasNext()) {
//                attribute = (LDAPAttribute)allAttributes.next();
//                attributeName = attribute.getName();
//                if ( (allValues = attribute.getStringValues()) != null
//                  && (attrValue = (String) allValues.nextElement()) != null) {
//                	map.put(attributeName, attrValue);
//                }
//            }
//            return map;
//        }catch( LDAPException e ) {
//            System.err.println( "\nOperationalAttrs() failed.");
//            System.err.println( "\nError: " + e.toString() );
//            System.exit(1);
//            return map;
//        }
//    }
//
//    public static void main( String[] args ){
//    	LdapUserAuth info = new LdapUserAuth();
//		//下面信息需要自己填写
//    	String ldapHost = "10.135.7.92";
//        String loginDN = "cn=httestuser,ou=user,o=services";
//		String loginPassword = "httestuser@0423";
//		String cn = "00000007";
//		String pwd = "Test,123";
//		//IDM
//		/*String loginDN="cn=usertest,o=services";
//		String loginPassword = "httestuser@0423";
//		String cn="usertest";
//		String pwd="usertest*2014";*/
//		//获取链接
//        LDAPConnection connection = getLDAPConnection(ldapHost,loginDN,loginPassword);
//		//获取用户dn
//        String dn = info.getDN(connection, cn);
//		//用户认证
//    	info.checkInfo( ldapHost, loginDN, loginPassword, dn, pwd);
//		//释放链接
//    	releaseLDAPConnection(connection);
//    }
//}
