import axios from '../../utils/axios'


// 获取当前用户信息
export function addSysUser(data) {
    return axios.post('/admin/sys-user', data)
}


export function getUserPage(params) {
    return axios.get('/admin/sys-user/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query // 将查询条件对象展开
        }
    });
}

// 删除多个用户
export function removeBatchUser(userIds) {
    return axios.delete('/admin/sys-user/batch', {
        data: userIds
    });
}


