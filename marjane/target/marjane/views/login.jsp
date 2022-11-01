<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 25/10/2022
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
</style>
<body>
<div class="font-mono min-h-full bg-[url('https://images.pexels.com/photos/7195232/pexels-photo-7195232.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1')] bg-auto flex flex-col justify-center py-12 sm:px-6 lg:px-8" style="font-family: Poppins">
    <div class="sm:mx-auto sm:w-full sm:max-w-md">
        <img class="mx-auto h-24 w-auto" src="https://www.marjane.ma/icons/logo_marjane.svg" alt="Workflow">
        <h2 class="mt-6 text-center text-3xl font-extrabold text-white">Welcome Admin</h2>
        <!--<p class="mt-2 text-center text-sm text-gray-600">
            Or
            <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500"> start your 14-day free trial </a>
        </p>-->
    </div>

    <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
        <div class="bg-white py-8 px-4 shadow  sm:px-10 ">
            <form class="space-y-6" action="Dashboard" method="POST">
                <div>
                    <label for="email" class="block text-sm font-medium text-gray-700"> Email address </label>
                    <div class="mt-1">
                        <input id="email" name="email" type="email" autocomplete="email" required class="appearance-none block w-full px-3 py-2 border border-gray-300  shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                    </div>
                </div>

                <div>
                    <label for="password" class="block text-sm font-medium text-gray-700"> Password </label>
                    <div class="mt-1">
                        <input id="password" name="password" type="password" autocomplete="current-password" required class="appearance-none block w-full px-3 py-2 border border-gray-300  shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                    </div>
                </div>

                <div class="flex items-center justify-between">
                    <div class="flex items-center">
                        <input id="remember-me" name="remember-me" type="checkbox" class="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 ">
                        <label for="remember-me" class="ml-2 block text-sm text-gray-900"> Remember me </label>
                    </div>

                    <div class="text-sm">
                        <a href="#" class="font-medium text-blue-800 hover:text-blue-900"> Forgot your password? </a>
                    </div>
                </div>



            <div class="mt-6">
                <div class="relative">
                    <div class="absolute inset-0 flex items-center">
                        <div class="w-full border-t border-gray-300"></div>
                    </div>
                    <div class="relative flex justify-center text-sm">
                        <span class="px-2 bg-white text-gray-500"> Choose Your position</span>
                    </div>
                </div>

                <fieldset class="mt-4 ">
                    <legend class="sr-only">Notification method</legend>
                    <div class="space-y-5 sm:flex sm:items-center sm:space-y-0 sm:space-x-10 ">
                        <div class="flex items-center  w-max">
                            <input id="adminGen" name="position" type="radio" value="adminGen" checked class="focus:ring-indigo-500 h-4 w-4 text-indigo-600 border-gray-300">
                            <label for="adminGen" class="ml-2 block text-sm font-medium text-gray-700"> Admin (Gen) </label>
                        </div>

                        <div class="flex items-center  w-max">
                            <input id="sms" name="position" type="radio" value="admin" class="focus:ring-indigo-500 h-4 w-4 text-indigo-600 border-gray-300">
                            <label for="sms" class="ml-2 block text-sm font-medium text-gray-700"> Admin </label>
                        </div>

                        <div class="flex items-center  w-max">
                            <input id="push" name="position" type="radio" value="chef" class="focus:ring-indigo-500 h-4 w-4 text-indigo-600 border-gray-300">
                            <label for="push" class="ml-2 block text-sm font-medium text-gray-700"> Chef Rayon </label>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div>
                <button type="submit" class="w-full flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium text-white bg-blue-800 hover:bg-blue-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Sign in</button>
            </div>
        </form>
        </div>

    </div>
</div>
</body>
</html>
