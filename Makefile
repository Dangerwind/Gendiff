run-dist:
	make -C app run-dist

checkstyleMain:
	make -C app checkstyleMain

build:
	make -C app build

test:
	make -C app test

report:
	make -C app report

.PHONY: build