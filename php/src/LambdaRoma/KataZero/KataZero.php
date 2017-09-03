<?php

namespace LambdaRoma\KataZero;

/**
 * Class UnoImperativo
 * @package LambdaRoma\KataZero
 */
class KataZero
{
    /**
     * @return array
     */
    public function kataZeroA(): array
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
    public function kataZeroB(): array
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
    public function kataZeroC(): array
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
    public function kataZeroD($names): array
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
     * @return int
     */
    public function kataZeroE(): int
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
    public function kataZeroF(): int
    {
        $sum = 0;
        for ($i = 6; $i <= 100; $i += 6) {
            $sum += $i;
        }
        return $sum;
    }

    /**
     * @param $menNames
     * @return array
     */
    public function kataZeroG(array $menNames): array
    {
        sort($menNames);
        return $menNames;
    }

    /**
     * @return int
     */
    public function kataZeroH(): int
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
    public function kataZeroI(array $menNames): string
    {
        return implode(", ", $menNames);
    }

    /**
     * @param $menNames
     * @return array
     */
    public function kataZeroJ(array $menNames): array
    {
        return array_unique($menNames);
    }

    /**
     * @param $womenNames
     * @return array
     */
    public function kataZeroK(array $womenNames): array
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

    /**
     * @param array $womenNames
     * @return array
     */
    public function kataZeroL(array $womenNames): array
    {
        $out = [];
        foreach ($womenNames as $name) {
            array_push($out, strlen($name));
        }
        return $out;
    }

    /**
     * @param array $womenNames
     * @return array
     */
    public function kataZeroM(array $womenNames): array
    {
        $out = [];
        foreach ($womenNames as $name) {
            array_push($out, $name[0]);
        }
        return $out;
    }
}
