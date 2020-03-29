package tech.chenxing;

import lombok.Data;

import java.util.List;

/**
 * 功能说明：
 *
 * @author fengqingyang
 * @return
 * @date [2020年03月29日上午12:21]
 */
@Data
public class Menu {
    private String title;
    private boolean collapsable=false;
    private Integer sidebarDepth=2;
    private List<List<String>> children;


}
