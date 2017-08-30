<?php

namespace spec\LambdaRoma\KataZero;

use LambdaRoma\KataZero\UnoImperativo;
use PhpSpec\ObjectBehavior;
use Prophecy\Argument;

class UnoImperativoSpec extends ObjectBehavior
{
    private $men = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"];
    private $women = ["Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara"];

    function it_is_initializable()
    {
        $this->shouldHaveType(UnoImperativo::class);
    }

    function it_should_return_123()
    {
        $this->kataZeroA()->shouldBe([1, 2, 3]);
    }

    function it_should_return_even_numbers()
    {
        $this->kataZeroB()->shouldBe([0, 2, 4, 6, 8, 10]);
    }

    function it_should_find_seven_multiple()
    {
        $this->kataZeroC()->shouldBe([7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98]);
    }

    function it_should_return_c_names()
    {
        $this->kataZeroD($this->men)->shouldBe(['Caio', 'Calpurnio']);
    }

    function it_should_return_average_of_eight_multiples()
    {
        $this->kataZeroE()->shouldBe(52);
    }

    function it_should_return_sum_of_six_multiples()
    {
        $this->kataZeroF()->shouldBe(816);
    }

    function it_should_order_men_names()
    {
        $this->kataZeroG($this->men)->shouldBe(['Caio', 'Calpurnio', 'Filano', 'Mevio', 'Sempronio', 'Tizio']);
    }

    function getMatchers()
    {
        return [
            'beMultipleOf41' => function ($subject) {
                return $subject % 41 === 0;
            }
        ];
    }

    function it_should_find_a_number_divisible_by_41()
    {
        $this->kataZeroH()->shouldBeMultipleOf41();
    }

    function it_should_return_a_string_with_men_names()
    {
        $this->kataZeroI($this->men)->shouldBe("Tizio, Caio, Sempronio, Mevio, Filano, Calpurnio");
    }

    function it_should_return_a_set_of_men_names()
    {
        $this->kataZeroJ($this->men)->shouldBe($this->men);
    }

    function it_should_return_a_map_of_ordered_women_names()
    {
        $this->kataZeroK($this->women)->shouldBe([
            4 => ["Anna", "Emma", "Sara"],
            5 => ["Carla", "Maria"],
            6 => ["Angela", "Chiara"]
        ]);
    }

}
