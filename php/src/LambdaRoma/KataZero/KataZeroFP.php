<?php

namespace LambdaRoma\KataZero;

use Qaribou\Collection\ImmArray;

class KataZeroFP
{
    /**
     * @return ImmArray
     */
    public function kataZeroA(): ImmArray
    {
        return ImmArray::fromArray(range(1, 3));
    }

    /**
     * @return array
     */
    public function kataZeroB(): array
    {
        return array_values(array_filter(range(0, 10), function ($i) {
            return $i % 2 === 0;
        }));
    }

    /**
     * @param $menNames
     * @return ImmArray
     */
    public function kataZeroD($menNames): ImmArray
    {
        return ImmArray::fromArray($menNames)->filter(function ($i) {
            return strtolower($i[0]) === 'c';
        });
    }

    /**
     * @return ImmArray
     */
    public function kataZeroC(): ImmArray
    {
        $g = function (int $limit, int $i = 7) {
            while ($i <= $limit) {
                yield $i;
                $i += 7;
            }
        };
        return ImmArray::fromItems($g(100));
    }

    /**
     * @return float|int
     */
    public function kataZeroE(): int
    {
        $g = function (int $limit, int $i = 8) {
            $counter = 0;
            while ($i <= $limit) {
                yield $i;
                $i += 8;
                $counter++;
            }
            return $counter;
        };
        $generator = $g(100);
        $total = ImmArray::fromItems($generator)->reduce(function ($last, $cur) {
            return $last + $cur;
        }, 0);

        return $total / $generator->getReturn();
    }

    /**
     * @return int
     */
    public function kataZeroE2(): int
    {
        $r = function (int $step, int $limit, int $acc = 0, int $counter = 0) use (&$r) {
            $curr = $counter * $step;
            return $counter * $step > $limit - $step
                ? $acc / $counter
                : $r($step, $limit, $acc + ($curr + $step), $counter + 1);
        };

        return $r(8, 100);
    }

    /**
     * @return int
     */
    public function kataZeroF(): int
    {
        return array_sum(range(6, 1000, 6));
    }

    /**
     * @return int
     */
    public function kataZeroF2(): int
    {
        $g = function () {
            yield from range(6, 1000, 6);
        };

        return ImmArray::fromItems($g())->reduce(function ($last, $curr) {
            return $last + $curr;
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
     * @param $menNames
     * @return ImmArray
     */
    public function kataZeroJ2(array $menNames): ImmArray
    {
        $set = ImmArray::fromArray(array_unique($menNames));
        $set[0] = "Cassio";
        return $set;
    }

    /**
     * @param $womenNames
     * @return array
     */
    public function kataZeroK(array $womenNames): array
    {
        $immutableWN = ImmArray::fromArray($womenNames);
        $ids = $immutableWN->map(function ($i) {
            return strlen($i);
        });
        $indexedWomenNames = ImmArray::fromArray(array_map(null, $ids->toArray(), $immutableWN->toArray()));

        $lambda = function ($or, $acc) use (&$lambda) {
            $first = array_shift($or);
            if (!$first) return $acc;
            $val = array_pop($first);
            $key = array_pop($first);
            if (isset($acc[$key]) && is_array($acc[$key])) {
                array_push($acc[$key], $val);
            } else {
                $acc[$key] = [$val];
            }
            return $lambda($or, $acc);
        };

        return $lambda($indexedWomenNames->toArray(), []);
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