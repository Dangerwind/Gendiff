
# Вычислитель отличий Gendiff
Программа сравнивает два файла, находит добавленные, удаленные, измененные или одинаковые записи и выводи информацию о всех изменениях.
Входные файлы могут быть в формате json тдт yaml (yml).


Первый проект "Игры разума" состоит из приветствия и 5 игр.
* Приветствие (Greet)
* Четное нечетное (Even)
* Счет в уме (Calc)
* Наибольший общий делитель (GCD)
* Прогрессии (Progression)
* Простые числа (Prime)

Скопируйте игру себе на компьютер и запустите.
```
cd
```
```
git -clone git@github.com:Dangerwind/java-project-71.git
```
```
cd java-project-71/app
```
Для вывода информации о программе и необходимых параметрах введите
```
./build/install/app/bin/app -h
```

![](https://github.com/Dangerwind/java-project-71/blob/main/GIF/01-help.gif)


| <!-- -->  | <!-- -->                                     |
|:----------|:---------------------------------------------|
| -h        | Общая информация                             |
| -V        | Версия программы                             |
| -f=format | Формат выходных данных: json, stylish, plain |
| filepath1 | путь к первому сравниваемому файлу           |
| filepath2 | путь ко второму сравниваемому файлу          |

После запуска выберите номер игры (от 1 до 6), и введите свое имя. Игра напишет правила, задаст вопрос "Question" и будет ожидать ответ "Your answer".
Необходимо ответить правильно 3 раза подряд. Если ответ будет не верным, игра закончится.

## 1 - Приветствие (Greet)
Просто спрашитвает ваше имя и выводит приветственную надпись.

## 2 - Четное нечетное (Even)
В игре надо определить четное число или нечетное и написать "yes" если четное или "no" если нечетное.

## 3 - Счет в уме (Calc)
Игра показывает формулу, необходимо вычислить результат в уме и написать ответ.

## 4 - Наибольший общий делитель (GCD)
Игра выводит 2 числа. Надо определить наибольший общий делитель для этих чисел.

## 5 - Прогрессии (Progression)
Игра выводит последовательность чисел заменив одно число на "..", необходимо высислить это число и написать его в ответ.

## 6 - Простые числа (Prime)
Игра выводит число, если это число простое, напишите "yes", в противном слечае напишите "no".





| <!-- --> |  <!-- --> |
| ---: | :--- |
| Hexlet tests/linter| [![Actions Status](https://github.com/Dangerwind/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Dangerwind/java-project-71/actions) |
| Java CI | [![Java CI](https://github.com/Dangerwind/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/Dangerwind/java-project-71/actions/workflows/main.yml) |
| Maintainability | [![Maintainability](https://api.codeclimate.com/v1/badges/89d9658bf7fac506ca70/maintainability)](https://codeclimate.com/github/Dangerwind/java-project-71/maintainability) |
| Test Coverage | [![Test Coverage](https://api.codeclimate.com/v1/badges/89d9658bf7fac506ca70/test_coverage)](https://codeclimate.com/github/Dangerwind/java-project-71/test_coverage) |
