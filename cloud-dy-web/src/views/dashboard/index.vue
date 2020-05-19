<template>
  <div class="dashboard-container">
    <component :is="currentRole" />
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import adminDashboard from './admin'
import dy from './dy'
import editorDashboard from './editor'

export default {
  name: 'Dashboard',
  components: { dy, editorDashboard },
  data() {
    return {
      // currentRole: 'adminDashboard'
      currentRole: 'dy'
    }
  },
  computed: {
    ...mapGetters([
      'roles'
    ])
  },
  created() {
    if (!this.roles.includes('admin')) {
      this.currentRole = 'editorDashboard'
    }
  }
}
</script>
