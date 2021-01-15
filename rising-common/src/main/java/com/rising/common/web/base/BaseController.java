package com.rising.common.web.base;

import com.rising.common.web.annotation.ResponseResult;
import com.rising.common.web.exception.ExceptionCast;
import com.rising.common.web.result.IResultCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：基本控制器
 * T: 传输实体
 * C：查询条件实体
 * 作者：李启云
 * 日期：2021-01-07
 */
public abstract class BaseController<T, R, C, ID extends Serializable> {

    /**
     * <p> 方法描述：初始化数据. </p>
     * <p> 创建时间：2020-02-05 11:02:24 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     */
    @ModelAttribute
    protected void setBeforeRequest() {
        //TODO 在每个请求前需要do.....
    }

    /**
     * 创建：李启云
     * 日期：2021-01-08
     * 描述：异常捕获
     *
     * @param resultCode 结果代码
     * @return
     */
    protected void cast(IResultCode resultCode) {
        ExceptionCast.cast(resultCode);
    }


    /**
     * 创建：李启云
     * 日期：2021-01-07
     * 描述：得到服务
     *
     * @return {@link BaseService<T, C, ID> }
     */
    @Autowired
    public abstract MeetBaseService<T, R, C, ID> getService();

    @ResponseResult
    @GetMapping(value = "/getOneById")
    @ApiOperation(value = "通过id获取")
    public R getOneById(ID id) throws Exception {
        return getService().get(id);
    }

    @ResponseResult
    @GetMapping
    @ApiOperation(value = "获取全部list数不带条件")
    public List<R> getAll() {
        return getService().getAll();
    }


    @ResponseResult
    @GetMapping("/getListByCondition")
    @ApiOperation(value = "获取全部list数不带条件")
    public List<R> getListByCondition(C condition) {
        return getService().findListByCondition(condition);
    }

    @ResponseResult
    @GetMapping(value = "/getPageByCondition")
    @ApiOperation(value = "分页获取条件查询")
    public Page<R> getPage(C condition, Pageable pageable) {
        return getService().findPageByCondition(condition, pageable);
    }

    @ResponseResult
    @PostMapping
    @ApiOperation(value = "保存数据")
    public R save(@RequestBody R entity) {
        return getService().save(entity);
    }

    @ResponseResult
    @PutMapping
    @ApiOperation(value = "更新数据")
    public R update(@RequestBody R entity) {
        return getService().update(entity);
    }

    @ResponseResult
    @DeleteMapping(value = "/{ids}")
    @ApiOperation(value = "批量通过id删除,传入ids")
    public void delByIds(@PathVariable("ids") ID[] ids) {
        for (ID id : ids) {
            getService().deleteById(id);
        }

    }

    @ResponseResult
    @DeleteMapping("/delById")
    @ApiOperation(value = "通过id删除,传入id")
    public void delById(ID id) {
        getService().deleteById(id);

    }
}