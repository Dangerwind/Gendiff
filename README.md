
[![Actions Status](https://github.com/Dangerwind/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Dangerwind/java-project-71/actions) 
[![Java CI](https://github.com/Dangerwind/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/Dangerwind/java-project-71/actions/workflows/main.yml) [![Maintainability](https://api.codeclimate.com/v1/badges/89d9658bf7fac506ca70/maintainability)](https://codeclimate.com/github/Dangerwind/java-project-71/maintainability) 
[![Test Coverage](https://api.codeclimate.com/v1/badges/89d9658bf7fac506ca70/test_coverage)](https://codeclimate.com/github/Dangerwind/java-project-71/test_coverage)

_Все аскинемы переконвертированные в gif файлы и сохранены в репозитории_

# Вычислитель отличий Gendiff
  Программа сравнивает два файла, находит добавленные, удаленные, измененные или одинаковые записи и выводи информацию о всех изменениях.
Входные файлы могут быть в формате json или yaml (yml).

  Скопируйте программу себе на компьютер:
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

  Используя выше приведенную инструкцию запустите сравнение файлов с выводом в формат plain:
```
./build/install/app/bin/app -f=plain path/file1.json path/file2.json
```
![](https://github.com/Dangerwind/java-project-71/blob/main/GIF/02-plain.gif)
 
  Или воспользуйтесь выводом в формат stylish:
```
./build/install/app/bin/app -f=stylish path/file1.json path/file2.json
```
![](https://github.com/Dangerwind/java-project-71/blob/main/GIF/03-stylish.gif)

  Или используйте формат json:
```
./build/install/app/bin/app -f=json path/file1.json path/file2.json
```
![](https://github.com/Dangerwind/java-project-71/blob/main/GIF/04-json.gif)
