<?php

namespace LambdaRoma\KataZero;

/**
 * Class UnoImperativo
 * @package LambdaRoma\KataZero
 */
class UnoImperativo
{
    const COMMA = ", ";

    /**
     * @param array $array
     * @return string
     */
    private function format(array $array)
    {
        return implode(self::COMMA, $array);
    }

    /**
     * @param int $number
     * @return bool
     */
    private function even(int $number)
    {
        return $number % 2 == 0;
    }

    /**
     * @return string
     */
    public function print123()
    {
        $out = [];
        for ($i = 1; $i <= 3; $i++) {
            array_push($out, $i);
        }

        return $this->format($out);
    }

    /**
     * @return string
     */
    public function evenNumbers()
    {
        $out = [];
        for($i = 1; $i <= 10; $i++) {
            if($this->even($i)) {
                array_push($out, $i);
            }
        }

        return $this->format($out);
    }

    /**
     * @return string
     */
    public function sevenMultiple()
    {
        $out = [];
        for($i = 1; $i <= 100; $i++) {
            if($i % 7 == 0) {
                array_push($out, $i);
            }
        }

        return $this->format($out);
    }

    /**
     * @param $names
     * @param string $disc
     * @return string
     */
    public function cMen($names, $disc = "c")
    {
        $out = [];
        foreach ($names as $name) {
            if($disc === strtolower($name[0])) {
                array_push($out, $name);
            }
        }

        return $this->format($out);
    }
}
