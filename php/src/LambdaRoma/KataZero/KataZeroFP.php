<?php

namespace LambdaRoma\KataZero;

use Illuminate\Support\Collection;

/**
 * Class KataZeroFP
 * @package LambdaRoma\KataZero
 */
class KataZeroFP
{
    /**
     * @return Collection
     */
    public function kataZeroA(): Collection
    {
        return collect(range(1, 3));
    }

    /**
     * @return Collection
     */
    public function kataZeroB(): Collection
    {
        return collect(range(0, 10, 2));
    }

    /**
     * @return Collection
     */
    public function kataZeroC(): Collection
    {
        return collect(range(7, 100, 7));
    }

    /**
     * @param array $menNames
     * @return Collection
     */
    public function kataZeroD($menNames): Collection
    {
        return collect($menNames)->filter(function ($i) {
            return strtolower($i[0]) === 'c';
        });
    }

    /**
     * @return int
     */
    public function kataZeroE(): int
    {
        return collect(range(8, 100, 8))->average();
    }

    /**
     * @return int
     */
    public function kataZeroF(): int
    {
        return collect(range(6, 1000, 6))->sum();
    }

    /**
     * @param array $menNames
     * @return Collection
     */
    public function kataZeroG(array $menNames): Collection
    {
        return collect($menNames)->sort();
    }

    /**
     * @return int
     */
    public function kataZeroH(): int
    {
        return collect(range(41, 1000, 41))->random();
    }

    /**
     * @param array $menNames
     * @return string
     */
    public function kataZeroI(array $menNames): string
    {
        return collect($menNames)->implode(", ");
    }

    /**
     * @param array $menNames
     * @return Collection
     */
    public function kataZeroJ(array $menNames): Collection
    {
        return collect($menNames)->unique();
    }

    /**
     * @param array $womenNames
     * @return Collection
     */
    public function kataZeroK(array $womenNames): Collection
    {
        return collect($womenNames)->groupBy(function ($item) {
            return strlen($item);
        });
    }

    /**
     * @param array $womenNames
     * @return Collection
     */
    public function kataZeroL(array $womenNames): Collection
    {
        return collect($womenNames)->map(function ($item) {
            return strlen($item);
        });
    }

    /**
     * @param $womenNames
     * @return Collection
     */
    public function kataZeroM($womenNames): Collection
    {
        return collect($womenNames)->map(function ($i) {
            return $i[0];
        });
    }
}
