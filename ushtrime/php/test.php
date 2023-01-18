<?php

abstract class Personi {
    private $emri = '';
    private $Mbiemri = '';
    private $dataLindjes = ;
    private $email = '';
    private $gjinia = '';

    public function setEmri($emri) {
        $this -> emri = $emri;
    }public function getemri() {
        return $this->emri;
    }

    public function setMbiemri($Mbiemri) {
        $this -> mbiemri = $Mbiemri;
    }public function getMbiemri() {
        return $this->Mbiemri;
    }

    public function setDataLindjes($dataLindjes) 



    
        $this -> dataLindjes - $dataLindjes;
    }public function getDataLindjes() {
        return $this ->dataLindjes;
    }

    public function setGjinia($gjinia) {
        $this -> gjinia = $gjinia;
    }public function getGjinia() {
        return $this -> gjinia;
    }

    abstract public function orariPunes() {

    }

}

?>