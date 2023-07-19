<?php

function dd($value){

echo "<pre>";

var_dump($value);

echo "</pre>";

die();

}


function urlis($value) {

return $_SERVER['REQUEST_URI'] === $value;  
}


 function authorize($condition,$status = Response::FORBITEN) {


    if(! $condition){
        abourt($status);
    }
    
}


?>
