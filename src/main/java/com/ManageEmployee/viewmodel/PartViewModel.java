package com.ManageEmployee.viewmodel;

import com.ManageEmployee.dto.PartDTO;

public class PartViewModel {
    private PartDTO part;
    private Integer departmentId;

    public PartDTO getPart() {
        return part;
    }

    public void setPart(PartDTO part) {
        this.part = part;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
