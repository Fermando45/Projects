<?php



$routs = require 'routers.php';


function routerToController($uri,$routs) {

    if(array_key_exists($uri,$routs)){

        require $routs[$uri];
    
    }else{
    
        abourt();
    
    
    }
}



function abourt($code = 404) {
    http_response_code($code);

    require "views/{$code}.php";
 
}

$uri = parse_url($_SERVER['REQUEST_URI'])['path'];


routerToController($uri,$routs);





?>