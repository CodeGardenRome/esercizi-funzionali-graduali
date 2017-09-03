<?php

namespace LambdaRoma\KataZero;

use Qaribou\Collection\ImmArray;

class KataZeroFP
{
    /**
     * @return ImmArray
     */
    public function kataZeroA()
    {
        return ImmArray::fromArray(range(1, 3));
    }

    /**
     * @return ImmArray
     */
    public function kataZeroB()
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
    public function kataZeroC()
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
    public function kataZeroD($menNames)
    {
        return ImmArray::fromArray($menNames)->filter(function ($i) {
            return strtolower($i[0]) === 'c';
        });
    }

    public function kataZeroE()
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
        $r = function (int $i, int $limit, int $sum = 8, int $counter = 0) use (&$r) {
            if ($sum >= $limit) return $sum / $counter;
            $sum += $i + $sum;
            $counter++;
            return $r($i, $limit, $sum, $counter);
        };

        return $r(8, 100);
    }

    public function kataZeroF()
    {
        // TODO: write logic here
    }


}
