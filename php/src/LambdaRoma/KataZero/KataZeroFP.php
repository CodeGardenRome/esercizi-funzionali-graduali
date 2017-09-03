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
     * @return ImmArray
     */
    public function kataZeroB(): ImmArray
    {
        $g = function (int $i, int $limit) {
            while ($i <= $limit) {
                yield $i;
                $i += 2;
            }
        };
        return ImmArray::fromItems($g(0, 10));
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
     * @return float|int
     */
    public function kataZeroE(): int
    {
        $lambda = function (int $limit, int $i = 8) {
            $counter = 0;
            while ($i <= $limit) {
                yield $i;
                $i += 8;
                $counter++;
            }
            return $counter;
        };
        $generator = $lambda(100);
        return ImmArray::fromItems($generator)->reduce(function ($last, $cur) {
                return $last + $cur;
            }, 0) / $generator->getReturn();
    }

    public function kataZeroE2()
    {
        $r = function (int $i, int $limit, int $acc = 0, int $counter = 0) use (&$r) {
            $curr = $counter * $i;
            return $counter * $i > $limit - $i
                ? $acc / $counter
                : $r($i, $limit, $acc + ($curr + $i), $counter + 1);
        };

        return $r(8, 100);
    }

    public function kataZeroF()
    {
        // TODO: write logic here
    }


}
