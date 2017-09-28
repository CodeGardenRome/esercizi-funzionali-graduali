<?php

namespace LambdaRoma\KataZero;

use Qaribou\Collection\ImmArray;

/**
 * Class KataZeroQaribu
 * @package LambdaRoma\KataZero
 */
class KataZeroQaribu
{
    /**
     * @return ImmArray
     */
    public function kataZeroA(): ImmArray
    {
        return ImmArray::fromArray(range(1, 3));
    }

    /**
     * @return ImmArray
     */
    public function kataZeroB(): ImmArray
    {
        return ImmArray::fromArray(range(0, 10, 2));
    }

    /**
     * @return ImmArray
     */
    public function kataZeroC(): ImmArray
    {
        return ImmArray::fromArray(range(7, 100, 7));
    }

    /**
     * @param array $menNames
     * @return ImmArray ImmArray
     */
    public function kataZeroD(array $menNames): ImmArray
    {
        return ImmArray::fromArray($menNames)->filter(function ($i) {
            return strtolower($i[0]) === 'c';
        });
    }

    /**
     * @return int
     */
    public function kataZeroE(): int
    {
        $range = ImmArray::fromArray(range(8, 100, 8));
        $count = $range->count();
        $sum = $range->reduce(function ($item, $carry) {
            return $carry + $item;
        }, 0);
        return $sum / $count;
    }

    /**
     * @return int
     */
    public function kataZeroF(): int
    {
        $range = ImmArray::fromArray(range(6, 1000, 6));
        return $range->reduce(function ($item, $carry) {
            return $carry + $item;
        }, 0);
    }

    /**
     * @param array $menNames
     * @return ImmArray
     */
    public function kataZeroG(array $menNames)
    {
        return ImmArray::fromArray($menNames)->sort();
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
     * @param $menNames
     * @return mixed|null
     */
    public function kataZeroI(array $menNames): string
    {
        return ImmArray::fromArray($menNames)->join(', ');
    }

    /**
     * @param $menNames
     * @return ImmArray
     */
    public function kataZeroJ(array $menNames): ImmArray
    {
        return ImmArray::fromArray(array_unique($menNames));
    }

    /**
     * @param array $womenNames
     * @return array
     */
    public function kataZeroK(array $womenNames): array
    {
        $immutableNames = ImmArray::fromArray($womenNames);
        return $immutableNames->reduce(function ($carry, $item) {
            $index = strlen($item);
            $carry[$index] = isset($carry[$index])
                ? array_merge($carry[$index], [$item])
                : [$item];
            return $carry;
        }, []);
    }

    /**
     * @param $womenNames
     * @return ImmArray
     */
    public function kataZeroL(array $womenNames): ImmArray
    {
        return ImmArray::fromArray($womenNames)->map(function ($i) {
            return strlen($i);
        });
    }

    /**
     * @param $womenNames
     * @return ImmArray
     */
    public function kataZeroM($womenNames): ImmArray
    {
        return ImmArray::fromArray($womenNames)->map(function ($i) {
            return $i[0];
        });
    }
}
