import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import CriarConta from '../components/CriarConta.vue'
import Configuracoes from '../components/Configuracoes.vue'
import Index from '../components/Index.vue'
import Lancamento from '../components/Lancamento.vue'
import Perfis from '../components/Perfis.vue'
import VisualizarLancamento from '../components/VisualizarLancamento.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/login',
        name: 'Login',
        component: Login
    },

    {
        path: '/criarconta',
        name: 'CriarConta',
        component: CriarConta
    },

    {
        path: '/configuracoes',
        name: 'Configuracoes',
        component: Configuracoes
    },

    {
        path: '/index',
        name: 'Index',
        component: Index
    },

    {
        path: '/lancamento',
        name: 'Lancamento',
        component: Lancamento
    },

    {
        path: '/perfis',
        name: 'Perfis',
        component: Perfis
    },

    {
        path: '/visualizarlancamento',
        name: 'VisualizarLancamento',
        component: VisualizarLancamento
    },

    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: function() {
            return import ( /* webpackChunkName: "about" */ '../views/About.vue')
        }
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router