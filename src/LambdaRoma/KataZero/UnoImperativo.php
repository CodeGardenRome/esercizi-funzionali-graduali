<?php

namespace LambdaRoma\KataZero;

/**
 * Class UnoImperativo
 * @package LambdaRoma\KataZero
 */
class UnoImperativo
{
    /**
     * @return string
     */
    public function print123()
    {
        $out = "";
        for ($i = 1; $i <= 3; $i++) {
            $out .= $i;
            $out .= $i !== 3 ? ", " : "";
        }

        return $out;
    }
}
