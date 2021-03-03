cmake_minimum_required(VERSION 3.0.0)
project(LEETCODING VERSION 0.1.0)

set (CMAKE_EXPORT_COMPILE_COMMANDS ON)

# set(CMAKE_VERBOSE_MAKEFILE ON)
set (MY_DEBUG_OPTIONS "-Wall")
# set (CMAKE_CXX_FLAGS_DEBUG "${CMAKE_CXX_FLAGS_DEBUG} -fno-omit-frame-pointer -fsanitize=address")
# set (CMAKE_LINKER_FLAGS_DEBUG "${CMAKE_LINKER_FLAGS_DEBUG} -fno-omit-frame-pointer -fsanitize=address")

add_executable(${CMAKE_PROJECT_NAME} DS_binary_tree.cpp)
# add_executable(${CMAKE_PROJECT_NAME} 2_add_two_numbers.cpp)
target_compile_options(${CMAKE_PROJECT_NAME} PUBLIC "$<$<CONFIG:DEBUG>:${MY_DEBUG_OPTIONS}>")

# include(CTest)
# enable_testing()
# set(CPACK_PROJECT_NAME ${PROJECT_NAME})
# set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
# include(CPack)
