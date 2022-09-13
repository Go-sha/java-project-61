#Makefile

run-dist: # run app
	@./app/build/install/app/bin/app

build-dist: # run installDist
	@gradle installDist
