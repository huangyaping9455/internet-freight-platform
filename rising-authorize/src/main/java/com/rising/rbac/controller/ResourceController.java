/**
 *
 */
package com.rising.rbac.controller;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.rbac.controller.support.SimpleResponse;
import com.rising.rbac.domain.Admin;
import com.rising.rbac.dto.ResourceInfo;
import com.rising.rbac.repository.support.BaseController;
import com.rising.rbac.service.impl.ResourceServiceImpl;
import com.rising.security.core.utils.ResultVOUtil;
import com.rising.security.core.vo.ResultVO;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * 版本：1.0.0
 * 描述：资源控制器
 *
 * @see BaseController
 * 码农：李齐云
 * 日期：2021-01-28
 */
@RestController
@RequestMapping("/sys/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceServiceImpl resourceService;


    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @ApiModelProperty("获取菜单信息")
    @GetMapping
    public ResultVO getTree() throws Exception {
        ResourceInfo tree = resourceService.getTree(admin.getId());
        long start = new Date().getTime();
        tree.setPermissions((Set<String>) redisTemplate.opsForValue().get(admin.getUsername()));
        long sed = new Date().getTime() -start;
        System.err.println("sed = " + sed);
        return ResultVOUtil.success(tree);
    }

    @ResponseResult
    @GetMapping("resourceList")
    public List<ResourceInfo> resourceList() throws Exception {
        List<ResourceInfo> resourceList = resourceService.getResourceList(admin.getId());
        return resourceList;
    }

    @ResponseResult
    @GetMapping("selectRootList")
    public List<ResourceInfo> selectList() throws Exception {
        List<ResourceInfo> resourceList = resourceService.getResourceList(admin.getId());
        ResourceInfo root = resourceService.findByName("root");
        resourceList.add(root);
        return resourceList;
    }

    /**
     * 获取资源信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResourceInfo getInfo(@PathVariable Long id) {
        return resourceService.getInfo(id);
    }

    /**
     * 创建资源
     *
     * @param info
     * @return
     */
    @ResponseResult
    @PostMapping
    public ResourceInfo create(@RequestBody ResourceInfo info) {
        if (info.getParentId() == null) {
            info.setParentId(0L);
        }
        return resourceService.create(info);
    }

    /**
     * 修改资源
     *
     * @param info
     * @return
     */
    @ResponseResult
    @PutMapping("/{menuId}")
    public ResourceInfo update(@RequestBody ResourceInfo info) {
        return resourceService.update(info);
    }

    /**
     * 删除
     *
     * @param id
     */
    @ResponseResult
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        resourceService.delete(id);
    }

    /**
     * 资源上移
     *
     * @param id
     */
    @PostMapping("/{id}/up")
    public SimpleResponse moveUp(@PathVariable Long id) {
        return new SimpleResponse(resourceService.move(id, true));
    }

    /**
     * 资源下移
     *
     * @param id
     */
    @PostMapping("/{id}/down")
    public SimpleResponse moveDown(@PathVariable Long id) {
        return new SimpleResponse(resourceService.move(id, false));
    }

}
