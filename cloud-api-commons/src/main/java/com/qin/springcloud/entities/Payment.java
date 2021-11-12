package com.qin.springcloud.entities;

import java.io.Serializable;

/**
 * description
 *
 * @author qcb
 * @date 2021/11/12 16:40.
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = -3634877619994185506L;

    private Long id;

    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
