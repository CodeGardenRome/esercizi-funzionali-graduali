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
     * @param array $numbers
     * @return string
     */
    private function format(array $numbers)
    {
        return implode(self::COMMA, $numbers);
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
}
