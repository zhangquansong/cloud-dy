import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/login/Login'
import Menu from '@/components/menu/Menu'

Vue.use(Router)

export default new Router({
  routes: [
  {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
        path: '/menu',
        name: 'Menu',
        component: Menu
      }
  ]
})
