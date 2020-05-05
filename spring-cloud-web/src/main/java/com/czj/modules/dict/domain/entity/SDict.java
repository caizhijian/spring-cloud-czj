package com.czj.modules.dict.domain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author caizhijian
 * @since 2020-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SDict extends Model<SDict> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String kindCode;

    private String code;

    private String detail;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
