<?php

require 'validation.php';


$heading = 'Create a note';

$config = require('config.php');

$db = new Database($config['database']);


if($_SERVER['REQUEST_METHOD'] === 'POST'){

    $body = $_POST['body'];

    $errors = [];


    if(!Validation::string($body,1,1000)){

        $errors['body'] = 'A body of no more than 1000 characters is required';

    }



    if(empty($errors)){
        $db->query('insert into notes("body", "user_id")'."values('$body',3)");

    }

    


}

require "views/notes/create.view.php";