<?php


$heading = "My notes";

$config = require('config.php');

$db = new Database($config['database']);

// $notes = pg_fetch_all($fetchall);

$id = $_GET['id'];

$note = $db->query('select * from notes where id = '.$id.' ');

$notes  = $db->findorfail();

$user_id = 3;

authorize($notes['user_id'] == $user_id,Response::FORBITEN);





require ('views/notes/show.view.php');







?>