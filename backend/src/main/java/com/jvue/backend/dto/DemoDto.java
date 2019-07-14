package com.jvue.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
public class DemoDto implements Serializable{
    private String[] result = null;
}
