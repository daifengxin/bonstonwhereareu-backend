package edu.bu.ec327.bostonwhereareu.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedDTO<T> {
    private int totalCount;
    private int offset;
    private int limit;
    private List<T> items;
}
