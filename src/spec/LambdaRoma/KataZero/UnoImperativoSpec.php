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

    function it_should_return_123()
    {
        $this->print123()->shouldBe("1, 2, 3");
    }

    function it_should_return_even_numbers()
    {
        $this->evenNumbers()->shouldBe("2, 4, 6, 8, 10");
    }

    function it_should_find_seven_multiple()
    {
        $this->sevenMultiple()->shouldBe("7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98");
    }
}
