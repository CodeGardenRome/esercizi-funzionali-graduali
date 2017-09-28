<?php

namespace LambdaRoma\KataZero;

/**
 * Class KataZeroFP
 * @package LambdaRoma\KataZero
 */
class KataZeroFP
{
    /**
     * @return array
     */
    public function kataZeroA(): array
    {
        return range(1, 3);
    }

    /**
     * @return array
     */
    public function kataZeroB(): array
    {
        return range(0, 10, 2);
    }

    /**
     * @return array
     */
    public function kataZeroC(): array
    {
        return range(7, 100, 7);
    }

    /**
     * @param array $menNames
     * @return array
     */
    public function kataZeroD(array $menNames): array
    {
        return array_values(array_filter($menNames, function ($item) {
            return strtolower($item[0]) === 'c';
        }));
    }

    /**
     * @return int
     */
    public function kataZeroE(): int
    {
        $range = range(8, 100, 8);
        return array_sum($range) / count($range);
    }

    /**
     * @return int
     */
    public function kataZeroF(): int
    {
        return array_sum(range(6, 1000, 6));
    }

    /**
     * @param array $menNames
     * @return array
     */
    public function kataZeroG(array $menNames): array
    {
        $menNamesToSort = $menNames;
        sort($menNamesToSort);
        return $menNamesToSort;
    }

    /**
     * @return int
     */
    public function kataZeroH(): int
    {
        $range = range(41, 1000, 41);
        return $range[array_rand($range)];
    }

    /**
     * @param array $menNames
     * @return string
     */
    public function kataZeroI(array $menNames): string
    {
        return implode(', ', $menNames);
    }

    /**
     * @param array $menNames
     * @return array
     */
    public function kataZeroJ(array $menNames): array
    {
        return array_unique($menNames);
    }

    /**
     * @param array $womenNames
     * @return array
     */
    public function kataZeroK(array $womenNames): array
    {
        return array_reduce($womenNames, function ($carry, $item) {
            $index = strlen($item);
            $carry[$index] = isset($carry[$index])
                ? array_merge($carry[$index], [$item])
                : [$item];
            return $carry;
        }, []);
    }

    /**
     * @param array $womenNames
     * @return array
     */
    public function kataZeroL(array $womenNames): array
    {
        return array_map(function ($item) {
            return strlen($item);
        }, $womenNames);
    }

    /**
     * @param $womenNames
     * @return array
     */
    public function kataZeroM($womenNames): array
    {
        return array_map(function ($item) {
            return $item[0];
        }, $womenNames);
    }
}
