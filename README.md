
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

Использую выше приведенную инструкцию запустите сравнение файлов с выводом в формат plain:
```
./build/install/app/bin/app -f=plain path/file1.json path/file2.json
```
![](https://github.com/Dangerwind/java-project-71/blob/main/GIF/02-plain.gif)
 
Или воспользуйтесь выводом в формат stylish:

![](https://github.com/Dangerwind/java-project-71/blob/main/GIF/03-stylish.gif)

Или используйте формат json:

![](https://github.com/Dangerwind/java-project-71/blob/main/GIF/04-json.gif)


| <!-- --> |  <!-- --> |
| ---: | :--- |
| Hexlet tests/linter| [![Actions Status](https://github.com/Dangerwind/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Dangerwind/java-project-71/actions) |
| Java CI | [![Java CI](https://github.com/Dangerwind/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/Dangerwind/java-project-71/actions/workflows/main.yml) |
| Maintainability | [![Maintainability](https://api.codeclimate.com/v1/badges/89d9658bf7fac506ca70/maintainability)](https://codeclimate.com/github/Dangerwind/java-project-71/maintainability) |
| Test Coverage | [![Test Coverage](https://api.codeclimate.com/v1/badges/89d9658bf7fac506ca70/test_coverage)](https://codeclimate.com/github/Dangerwind/java-project-71/test_coverage) |
