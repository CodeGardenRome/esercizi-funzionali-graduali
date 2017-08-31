<?php

namespace LambdaRoma\KataZero;

/**
 * Class UnoImperativo
 * @package LambdaRoma\KataZero
 */
class UnoImperativo //todo cambia il nome
{
    /**
     * @return array
     */
    public function kataZeroA()
    {
        $out = [];
        for ($i = 1; $i <= 3; $i++) {
            array_push($out, $i);
        }

        return $out;
    }

    /**
     * @return array
     */
    public function kataZeroB()
    {
        $out = [];
        for ($i = 0; $i <= 10; $i += 2) {
            array_push($out, $i);
        }
        return $out;
    }

    /**
     * @return array
     */
    public function kataZeroC()
    {
        $out = [];
        for ($i = 7; $i <= 100; $i += 7) {
            array_push($out, $i);
        }
        return $out;
    }

    /**
     * @param $names
     * @return array
     */
    public function kataZeroD($names)
    {
        $out = [];
        foreach ($names as $name) {
            if ("c" === strtolower($name[0])) {
                array_push($out, $name);
            }
        }
        return $out;
    }

    /**
     * @return float|int
     */
    public function kataZeroE()
    {
        $multiples = 0;
        $out = 0;
        for ($i = 8; $i <= 100; $i += 8) {
            $multiples++;
            $out += $i;
        }
        return $out / $multiples;
    }

    /**
     * @return int
     */
    public function kataZeroF()
    {
        $sum = 0;
        for ($i = 6; $i <= 100; $i += 6) {
            $sum += $i;
        }
        return $sum;
    }

    /**
     * @param $menNames
     * @return bool
     */
    public function kataZeroG($menNames)
    {
        sort($menNames);
        return $menNames;
    }

    /**
     * @return int
     */
    public function kataZeroH()
    {
        $out = [];
        for ($i = 41; $i <= 1000; $i += 41) {
            array_push($out, $i);
        }
        $randomicIndex = rand(0, sizeof($out) - 1);
        return $out[$randomicIndex];
    }

    /**
     * @param $menNames
     * @return string
     */
    public function kataZeroI($menNames)
    {
        return implode(", ", $menNames);
    }

    /**
     * @param $menNames
     * @return array
     */
    public function kataZeroJ($menNames)
    {
        return array_unique($menNames);
    }

    /**
     * @param $womenNames
     * @return array
     */
    public function kataZeroK($womenNames)
    {
        $out = [];
        foreach ($womenNames as $name) {
            if (isset($out[strlen($name)])) {
                array_push($out[strlen($name)], $name);
                continue;
            }
            $out[strlen($name)] = [$name];
        }
        return $out;
    }
}
