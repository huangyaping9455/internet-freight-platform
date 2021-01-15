/**
 *
 */
package com.rising.rbac.init;

import com.rising.rbac.domain.*;
import com.rising.rbac.dto.OrganizationType;
import com.rising.rbac.dto.ResourceType;
import com.rising.rbac.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 默认的系统数据初始化器，永远在其他数据初始化器之前执行
 *
 * @author liqiyun
 */
@Component
public class AdminDataInitializer extends AbstractDataInitializer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleAdminRepository roleAdminRepository;

    @Autowired
    protected ResourceRepository resourceRepository;


    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private RoleOrganizationRepository roleOrganizationRepository;

    /**
     * (non-Javadoc)
     *
     * @see DataInitializer#getIndex()
     */
    @Override
    public Integer getIndex() {
        return Integer.MIN_VALUE;
    }

    @Override
    protected void doInit() {
        initResource();
        Role role = initRole();
//        initUsergroup();

        Role role1 = initRole1();
        Role role2 = initRole2();
        initAdmin(role, role1, role2);
    }

//    初始化用户组数据


    /**
     * 初始化用户数据
     *
     * @param role the role
     */
    private void initAdmin(Role role, Role role1, Role role2) {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setEmail("478668865@qq.com");
        admin.setMobile("18788523442");
        admin.setPassword(passwordEncoder.encode("123456"));
        Admin user1 = new Admin();
        user1.setUsername("user1");
        user1.setEmail("478668865@qq.com");
        user1.setMobile("18788523442");
        user1.setPassword(passwordEncoder.encode("123456"));

        Admin user2 = new Admin();
        user2.setUsername("user2");
        user2.setEmail("478668865@qq.com");
        user2.setMobile("18788523442");
        user2.setPassword(passwordEncoder.encode("123456"));

        //初始化用户和组织机构
        initUserGroup(admin, user1, user2, role, role1, role2);


        //关联角色用户
        RoleAdmin roleAdmin = new RoleAdmin();
        //关联权限和用户
        roleAdmin.setRole(role);
        roleAdmin.setAdmin(admin);
        roleAdminRepository.save(roleAdmin);

        //---------------------
        RoleAdmin roleAdmin1 = new RoleAdmin();
        roleAdmin1.setRole(role1);
        roleAdmin1.setAdmin(user1);
        roleAdminRepository.save(roleAdmin1);

        RoleAdmin roleAdmin2 = new RoleAdmin();
        roleAdmin2.setRole(role2);
        roleAdmin2.setAdmin(user2);
        roleAdminRepository.save(roleAdmin2);
        //---------------------------


    }

    /**
     * 初始化角色数据
     *
     * @return
     */
    private Role initRole() {
        Role role = new Role();
        role.setName("超级管理员");
        roleRepository.save(role);
        return role;
    }


    private Role initRole1() {
        Role role1 = new Role();
        role1.setName("昆明中西科技角色");
        roleRepository.save(role1);
        return role1;
    }

    private Role initRole2() {
        Role role2 = new Role();
        role2.setName("昆明亿玺科技角色");
        roleRepository.save(role2);
        return role2;
    }

    /**
     * 创建：李启云
     * 日期：2020-12-09
     * 描述：初始化用户组
     *
     * @param admin 管理
     * @param user1 user1
     * @param user2 user2
     * @param role  角色
     * @param role1 role1的角色
     * @param role2 role2
     * @return {@link Organization }
     */

    protected Organization initUserGroup(Admin admin, Admin user1, Admin user2, Role role, Role role1, Role role2) {
        Organization root = createUserGroupRoot("平台", admin, role);
        Organization userGroup1 = createUserGroup("昆明中西科技", user1, role1, root, OrganizationType.COMPANY.getValue());
        Organization userGroup2 = createUserGroup("昆明亿玺科技", user2, role2, root, OrganizationType.COMPANY.getValue());
        createDept("财务部门", userGroup1, OrganizationType.DEPARTMENT.getValue());
        createDept("开发部门", userGroup1, OrganizationType.DEPARTMENT.getValue());
        createDept("行政部门", userGroup1, OrganizationType.DEPARTMENT.getValue());
        createDept("Java开发部", userGroup2, OrganizationType.DEPARTMENT.getValue());
        createDept("C++开发部", userGroup2, OrganizationType.DEPARTMENT.getValue());
        createDept("PHP开发部", userGroup2, OrganizationType.DEPARTMENT.getValue());
        return root;

    }

    /**
     * <p> 方法描述：创建用户组. </p>
     * <p> 创建时间：2020-05-03 10:48:11 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param name   the name
     * @param parent the parent
     * @return resource resource
     */
    protected Organization createUserGroup(String name, Admin admin, Role role, Organization parent, Integer type) {
        Organization node = new Organization();
        node.setName(name);
        node.setParent(parent);
        node.setType(type);
        admin.setOrganization(node);
        node.addAdmin(admin);
        organizationRepository.save(node);


        //关联角色和用户组
        RoleOrganization roleOrganization = new RoleOrganization();
        roleOrganization.setRole(role);
        roleOrganization.setOrganization(node);
        roleOrganizationRepository.save(roleOrganization);

        return node;
    }


    protected Organization createDept(String name, Organization parent, Integer type) {
        Organization node = new Organization();
        node.setName(name);
        node.setParent(parent);
        node.setType(type);
        organizationRepository.save(node);
        return node;
    }


    /**
     * <p> 方法描述：创建用户组根节点. </p>
     * <p> 创建时间：2020-04-30 13:39:13 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param name the name
     * @return resource
     */
    protected Organization createUserGroupRoot(String name, Admin admin, Role role) {
        Organization node = new Organization();
        node.setName(name);
        admin.setOrganization(node);
        node.addAdmin(admin);
        organizationRepository.save(node);


        //关联角色和用户组
        RoleOrganization roleOrganization = new RoleOrganization();
        roleOrganization.setRole(role);
        roleOrganization.setOrganization(node);
        roleOrganizationRepository.save(roleOrganization);
        return node;
    }

    /**
     * 创建：李启云
     * 日期：2020-12-09
     * 描述：初始化资源
     *
     * @return
     */
    protected void initResource() {
        Resource root = createRoot("root");

        // createResource("首页", "", "home", ResourceType.CATALOG.getValue(), root);

        Resource system = createResource("系统管理", "", "", "system", ResourceType.CATALOG.getValue(), root);
        Resource platform = createResource("平台管理", "", "", "system", ResourceType.CATALOG.getValue(), root);

        createResource("管理员列表", "sys/user", "get/uaa/sys/admin/**", "admin", ResourceType.MENU.getValue(), system);
        createResource("角色管理", "sys/role", "get/uaa/sys/role/**", "role", ResourceType.MENU.getValue(), system);

        createResource("SQL监控", "http://gateway.api/uaa/druid/sql.html", "", "sql", ResourceType.MENU.getValue(), system);
        createResource("定时任务", "job/schedule", "", "job", ResourceType.MENU.getValue(), system);
        createResource("参数管理", "sys/config", "", "config", ResourceType.MENU.getValue(), system);
        createResource("系统日志", "sys/log", "", "log", ResourceType.MENU.getValue(), system);


        createResource("商家入住", "sys/user", "", "admin", ResourceType.MENU.getValue(), platform);
        createResource("会员管理", "sys/role", "", "role", ResourceType.MENU.getValue(), platform);
        createResource("菜单管理", "sys/menu", "get/uaa/sys/resource/**", "menu", ResourceType.MENU.getValue(), platform);
        createResource("企业管理", "platform/company", "get/uaa/sys/organization/**", "menu", ResourceType.MENU.getValue(), platform);


    }

    /**
     * 创建：李启云
     * 日期：2020-11-23
     * 描述：创建资源
     *
     * @param name     的名字
     * @param url      url
     * @param iconName 图标的名字
     * @param type     类型
     * @param parent   父
     * @return {@link Resource }
     */
    protected Resource createResource(String name, String url, String perms, String iconName, Integer type, Resource parent) {
        Resource node = new Resource();
        node.setName(name);
        node.setIcon(iconName);
        node.setParent(parent);
        node.setParentName(parent.getName());
        node.setType(type);
        node.setUrl(url);
        node.setPerms(perms);
        if (StringUtils.isNotBlank(perms)) {
            Set<String> permsSet = Arrays.stream(StringUtils.deleteWhitespace(perms).split(","))
                    .collect(Collectors.toSet());
            if (StringUtils.isNotBlank(url)) {
                permsSet.add(url);
            }

            node.setUrls(permsSet);
        }
        resourceRepository.save(node);
        return node;
    }

    @Override
    protected boolean isNeedInit() {
        return adminRepository.count() == 0;
    }

    /**
     * <p> 方法描述：创建菜单资源根节点. </p>
     * <p> 创建时间：2020-04-30 13:39:13 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param name the name
     * @return resource
     */
    protected Resource createRoot(String name) {
        Resource node = new Resource();
        node.setName(name);
        resourceRepository.save(node);
        return node;
    }

    /**
     * <p> 方法描述：Create resource resource. </p>
     * <p> 创建时间：2020-05-02 00:44:14 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param name   the name
     * @param parent the parent
     * @return resource
     */
    protected Resource createResource(String name, Resource parent) {
        return createResource(name, null, null, null, null, parent);
    }


}
