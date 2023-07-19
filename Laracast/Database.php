<?php
class Database {


public $connection;

public $staitment;

public function __construct($config)  {

  

    $connection = http_build_query($config,"",' ');
    

    $this->connection = pg_connect($connection);;

    
}



public function query($query) {



    $this->staitment = pg_query($this->connection,$query);



    return $this->staitment;

    
}




public function get() {


    $fetch = pg_fetch_all($this->staitment);

    return $fetch;
    
}

public function findorfail()  {

    $fetch = pg_fetch_array($this->staitment);

    if(!$fetch){

        abourt();
    }

    return $fetch;
    
}




}
