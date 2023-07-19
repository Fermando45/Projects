<?php


class Validation{



    public static function string($value,$min = 1,$max = INF){

        $value = trim($value);

        $cond = $value >= $min && strlen($value) <= $max;

        return $cond;
        
    }

    public static function email($value) {

        return filter_var($value,FILTER_VALIDATE_EMAIL);


        
    }




}












?>