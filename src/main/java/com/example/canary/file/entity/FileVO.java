package com.example.canary.file.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.io.Serial;

/**
 * 文件
 *
 * @author zhaohongliang 2023-09-22 21:36
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileVO extends FileBase {

    @Serial
    private static final long serialVersionUID = -129723743991801184L;

    public FileVO() {
    }

    public FileVO(FilePO filePo) {
        BeanUtils.copyProperties(filePo, this);
    }
}
