cmake_minimum_required(VERSION 3.19)
project(242_a2 C)

set(CMAKE_C_STANDARD 90)

include_directories(asgn)

add_executable(242_a2
        asgn/asgn2.c
        asgn/mylib.c
        asgn/mylib.h
        asgn/tree.c
        asgn/tree.h)

target_link_libraries(242_a2 m)