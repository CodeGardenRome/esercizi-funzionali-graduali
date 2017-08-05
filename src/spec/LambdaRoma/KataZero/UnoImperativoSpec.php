<?php

namespace spec\LambdaRoma\KataZero;

use LambdaRoma\KataZero\UnoImperativo;
use PhpSpec\ObjectBehavior;
use Prophecy\Argument;

class UnoImperativoSpec extends ObjectBehavior
{
    function it_is_initializable()
    {
        $this->shouldHaveType(UnoImperativo::class);
    }
}
