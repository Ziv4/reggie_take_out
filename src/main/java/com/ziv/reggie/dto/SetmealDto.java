package com.ziv.reggie.dto;


import com.ziv.reggie.entity.Setmeal;
import com.ziv.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
