<?php


$heading = "My notes";

$config = require('config.php');

$db = new Database($config['database']);

$fetchall = $db->query('select * from notes where user_id = 3');

$notes = $db->get();

require ('views/notes/index.view.php');







?>